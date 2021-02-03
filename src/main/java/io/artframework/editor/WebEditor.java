package io.artframework.editor;

import io.artframework.Scope;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.net.URL;
import java.util.List;
import java.util.function.Consumer;

@Data
@Accessors(fluent = true)
public class WebEditor implements FlowEditor<Consumer<URL>> {

    private final Scope scope;

    @Override
    public EditorSession<Consumer<URL>, List<String>> edit(List<String> input) {

        return new DefaultSession<>(this, input);
    }

    /**
     * Creates a new web editor session for the given edit session.
     * <p>The target consumer gets a callback with the link that should be opened by the user.
     *
     * @param linkCallback the callback that is called with the link once the web editor is ready
     * @param session the session that should open in the editor. must not be null.
     */
    @Override
    public void open(@NonNull Consumer<URL> linkCallback, @NonNull EditorSession<Consumer<URL>, List<String>> session) {

        // TODO: implement
    }
}
