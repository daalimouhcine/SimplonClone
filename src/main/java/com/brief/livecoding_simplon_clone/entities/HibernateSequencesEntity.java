package com.brief.livecoding_simplon_clone.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "hibernate_sequences", schema = "livecoding_simplon_clone", catalog = "")
public class HibernateSequencesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "sequence_name")
    private String sequenceName;
    @Basic
    @Column(name = "next_val")
    private Long nextVal;

    public String getSequenceName() {
        return sequenceName;
    }

    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
    }

    public Long getNextVal() {
        return nextVal;
    }

    public void setNextVal(Long nextVal) {
        this.nextVal = nextVal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HibernateSequencesEntity that = (HibernateSequencesEntity) o;

        if (sequenceName != null ? !sequenceName.equals(that.sequenceName) : that.sequenceName != null) return false;
        if (nextVal != null ? !nextVal.equals(that.nextVal) : that.nextVal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sequenceName != null ? sequenceName.hashCode() : 0;
        result = 31 * result + (nextVal != null ? nextVal.hashCode() : 0);
        return result;
    }
}
