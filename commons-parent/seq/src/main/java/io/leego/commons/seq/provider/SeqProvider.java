package io.leego.commons.seq.provider;

import io.leego.commons.seq.exception.SeqNotFoundException;

/**
 * @author Leego Yih
 */
public interface SeqProvider {

    /**
     * Returns the next sequence.
     *
     * @param key the key of the sequence.
     * @return the next sequence.
     * @throws SeqNotFoundException if the sequence is missing
     */
    long next(String key);

    /**
     * Returns the next segment.
     *
     * @param key  the key of the sequence.
     * @param size the size to be obtained
     * @return the next segment.
     * @throws IllegalArgumentException if the size is negative
     * @throws SeqNotFoundException     if the sequence is missing
     */
    Segment next(String key, int size);

    /**
     * Creates a sequence.
     *
     * @param key       the key of the sequence.
     * @param value     the initialized value of the sequence.
     * @param increment the increment of the sequence.
     * @return {@code true} if the sequence is created.
     */
    boolean create(String key, long value, int increment);

    /**
     * Updates a sequence.
     *
     * @param key       the key of the sequence.
     * @param increment the increment of the sequence.
     * @return {@code true} if the sequence is updated.
     */
    boolean update(String key, int increment);

    /**
     * Returns {@code true} if this provider contains a sequence for the specified key.
     *
     * @param key the key of the sequence.
     * @return {@code true} if this provider contains a sequence for the specified key.
     */
    boolean contains(String key);

    /**
     * Creates a sequence with the value of 0 and the increment of 1.
     *
     * @param key the key of the sequence.
     * @return {@code true} if the sequence is created.
     */
    default boolean create(String key) {
        return this.create(key, 0, 1);
    }

}
