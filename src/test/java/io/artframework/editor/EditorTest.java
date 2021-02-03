package io.artframework.editor;

import io.artframework.MessageSender;
import io.artframework.Scope;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SuppressWarnings("ALL")
class EditorTest {

    private DummyEditor editor;

    @BeforeEach
    void setUp() {

        editor = new DummyEditor(Scope.defaultScope());
    }

    @Test
    @DisplayName("should remember edit history")
    void shouldRememberEditHistory() {


        EditorSession<MessageSender, List<String>> session = editor.edit(Arrays.asList(
                "foo",
                "bar"
        )).set(Arrays.asList("bar", "foo"));

        assertThat(session.changes())
                .hasSize(1)
                .contains(new Change<>(
                        Arrays.asList("foo", "bar"),
                        Arrays.asList("bar", "foo")
                ));
    }

    @Test
    @DisplayName("should fire change event")
    void shouldFireChangeEvent() {

        Consumer<EditorSession<MessageSender, List<String>>> callback = spy(new Consumer<>() {
            @Override
            public void accept(EditorSession<MessageSender, List<String>> session) {

                assertThat(session.output()).isEqualTo(Arrays.asList("bar"));
            }
        });

        EditorSession<MessageSender, List<String>> editorSession = editor.edit(Arrays.asList("foo"))
                .onChange(callback);

        editorSession.set(Arrays.asList("bar"));

        verify(callback, times(1)).accept(any());
    }
}