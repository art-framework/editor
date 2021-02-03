package io.artframework.editor;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.function.Consumer;

@Data
@Accessors(fluent = true)
public abstract class AbstractEditorSession<TTarget, TValue> implements EditorSession<TTarget, TValue> {

    private final Editor<TTarget, TValue> editor;
    private final String identifier;
    private final TValue input;
    private final TValue output;

    private final Stack<Change<TValue>> changes = new Stack<>();
    private final Set<Consumer<EditorSession<TTarget, TValue>>> changeListeners = new HashSet<>();

    protected AbstractEditorSession(Editor<TTarget, TValue> editor, String identifier, TValue input) {

        this.editor = editor;

        this.identifier = identifier;

        this.input = input;
        this.output = input;
    }

    protected AbstractEditorSession(EditorSession<TTarget, TValue> session, TValue output) {

        this.editor = session.editor();

        this.identifier = session.identifier();
        this.input = session.input();
        this.output = output;
    }

    protected abstract AbstractEditorSession<TTarget, TValue> create(EditorSession<TTarget, TValue> session, TValue newValue);

    @Override
    public final Collection<Change<TValue>> changes() {

        return List.copyOf(changes);
    }

    @Override
    public final EditorSession<TTarget, TValue> set(TValue value) {

        if (value == null && output == null) return this;
        if (output != null && output.equals(value)) return this;
        if (value != null && value.equals(output)) return this;

        AbstractEditorSession<TTarget, TValue> session = create(this, value);

        session.changes.addAll(changes);
        session.changes.push(new Change<>(output(), value));
        session.changeListeners.addAll(changeListeners());

        changeListeners.forEach(listener -> listener.accept(session));

        return session;
    }

    @Override
    public final EditorSession<TTarget, TValue> onChange(Consumer<EditorSession<TTarget, TValue>> callback) {

        this.changeListeners.add(callback);

        return this;
    }
}
