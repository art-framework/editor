package io.artframework.editor;

import io.artframework.MessageSender;
import io.artframework.Scope;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(fluent = true)
public class DummyEditor implements FlowEditor<MessageSender> {

    private final Scope scope;

    @Override
    public EditorSession<MessageSender, List<String>> edit(List<String> input) {

        return new DefaultSession<>(this, input);
    }

    @Override
    public void open(@NonNull MessageSender messageSender, @NonNull EditorSession<MessageSender, List<String>> session) {

    }
}
