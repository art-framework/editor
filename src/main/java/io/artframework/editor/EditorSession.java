package io.artframework.editor;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * The editor session keeps track of all changes made
 * to the input given to the editor.
 * <p>Create a new session with {@link Editor#edit(Object)}
 * and then subscribe to the {@link #onChange(Consumer)} event.
 * <h2>Implementation Notice</h2>
 * Every editor session must be immutable and should return a new session
 * when the output value is altered.
 * <pre>{@code
 * Editor.edit(config.get("foobar"))
 *      .onChange(session -> config.set("foobar", session.output()));
 * }</pre>
 * @param <TValue> the input type of the editor and editor session
 */
public interface EditorSession<TValue> {

    /**
     * Each editor session is identified by a unique string.
     * <p>The identifier is used to keep track of different sessions
     * opening and closing them using the {@link Editor}.
     *
     * @return the unique identifier of this editor session
     */
    String identifier();

    /**
     * @return the input of the editor session
     */
    TValue input();

    /**
     * The output is the same as the input as long
     * as the editor session has not been changed.
     *
     * @return the final output of the editor session
     */
    TValue output();

    /**
     * Sets the output value of this edtior session to the given value.
     * <p>A {@link #onChange(Consumer)} event is fired if the value changed.
     *
     * @param value the new value of this session
     * @return an new editor session with the new output value
     */
    EditorSession<TValue> set(TValue value);

    /**
     * The change history holds a list of all changes that
     * happended during the lifetime of this editor session.
     * <p>Only actual changes have a difference in their value
     * and called {@link #onChange(Consumer)} are recorded.
     * <p>The change history maybe empty if no change happended.
     * <p>The change list is in reverse order. Meaning the last
     * change is always at index 0 and the first change at {@code length-1}.
     *
     * @return an immutable list of all changes in reverse order of this editor session
     */
    Collection<Change<TValue>> changes();

    /**
     * The change callback is called everytime a change happended
     * to the input of the session.
     * <p>The changed value is reflected in the {@link #output()}.
     * <p>The change callback may be called multiple times per editor
     * session but only if the value given to {@link #set(Object)} actually changed.
     *
     * @param callback the callback that consumes the change event
     * @return this editor session
     */
    EditorSession<TValue> onChange(Consumer<EditorSession<TValue>> callback);
}
