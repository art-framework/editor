package io.artframework.editor;

import lombok.Value;

/**
 * The change record holds both the new and old value of a change.
 *
 * @param <TValue> the type of the value that changed
 */
@Value
public class Change<TValue> {

    TValue oldValue;
    TValue value;
}
