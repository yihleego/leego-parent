package io.leego.support.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.Objects;

/**
 * @author Leego Yih
 */
@Getter
@Setter
@ToString(callSuper = true)
@FieldNameConstants
@MappedSuperclass
public abstract class CrudEntity<ID> extends BaseEntity<ID> implements Creatable, Updatable, Deletable<ID> {
    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected Instant createdTime;
    @LastModifiedDate
    protected Instant updatedTime;
    @Column(insertable = false, updatable = false)
    protected ID deleted;
    @Column(insertable = false, updatable = false)
    protected Instant deletedTime;

    /**
     * Returns {@code true} if it has been deleted,
     * that is, when the {@code deleted} is equal to the {@code id}.
     *
     * @see io.leego.support.jpa.repository.DeletableRepository
     */
    @Override
    public boolean isDeleted() {
        return Objects.equals(getDeleted(), getId());
    }
}
