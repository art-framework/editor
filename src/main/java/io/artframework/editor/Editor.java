package io.artframework.editor;

import io.artframework.Provider;
import lombok.NonNull;

import java.util.function.Consumer;

/**
 * The editor takes your input and handles the resulting editor session, allowing you to open and edit it.
 * <p>To create a new session call {@link #edit(Object)} and then open the session for
 * the given target type of the editor: {@link #open(Object, EditorSession)}.
 * <p>You can retrieve the registered editor with {@link io.artframework.Scope#get(Class)}.
 * Make sure to get the concrete implemention of the editor to get the correct types.
 *
 * <h2>Implementation Notice</h2>
 * The editing logic should be implemented inside the editor and not in the session.
 * Use the session only to track the subscribers and data that is changed.
 * <p>The editor can be anykind of editor, even a remote web editor that is
 * handling commands to open and close edit sessions.
 *
 * @param <TTarget> the type of the target that can open the editor
 * @param <TType> the value type that can be edited
 */
public interface Editor<TTarget, TType> extends Provider {

    /**
     * Starts a new edit session for the given input value.
     * <p>Call {@link #open(Object, EditorSession)} with the created session and
     * required target type to open the editor with your session.
     *
     * @param input the input of the editing session. can be null.
     * @return the new edit session
     */
    EditorSession<TType> edit(TType input);

    /**
     * Opens the given editor session for the given target.
     * <p>Make sure to subscribe to the changes of the session with {@link EditorSession#onChange(Consumer)}.
     *
     * @param target the target to open the editor for. must not be null.
     * @param session the session that should open in the editor. must not be null.
     */
    void open(@NonNull TTarget target, @NonNull EditorSession<TType> session);
}
