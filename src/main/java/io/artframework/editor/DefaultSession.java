package io.artframework.editor;

import java.util.List;
import java.util.UUID;

public final class DefaultSession extends AbstractEditorSession<List<String>> {

    public DefaultSession(List<String> input) {

        super(UUID.randomUUID().toString(), input);
    }

    DefaultSession(String identifier, List<String> input) {

        super(identifier, List.copyOf(input));
    }

    private DefaultSession(String identifier, List<String> input, List<String> output) {

        super(identifier, List.copyOf(input), List.copyOf(output));
    }

    @Override
    protected AbstractEditorSession<List<String>> create(EditorSession<List<String>> session, List<String> newValue) {

        return new DefaultSession(identifier(),session.input(), newValue);
    }

}
