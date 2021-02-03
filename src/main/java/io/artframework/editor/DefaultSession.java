package io.artframework.editor;

import java.util.List;
import java.util.UUID;

public final class DefaultSession<TTarget> extends AbstractEditorSession<TTarget, List<String>> {

    public DefaultSession(Editor<TTarget, List<String>> editor, List<String> input) {

        super(editor, UUID.randomUUID().toString(), List.copyOf(input));
    }

    private DefaultSession(DefaultSession<TTarget> session, List<String> output) {

        super(session, List.copyOf(output));
    }

    @Override
    protected AbstractEditorSession<TTarget, List<String>> create(EditorSession<TTarget, List<String>> session, List<String> newValue) {

        return new DefaultSession<>(this, newValue);
    }

}
