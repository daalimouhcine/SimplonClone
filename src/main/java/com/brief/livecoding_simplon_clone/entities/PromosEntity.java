package com.brief.livecoding_simplon_clone.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "promos", schema = "livecoding_simplon_clone", catalog = "")
public class PromosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "formateurId")
    private Integer formateurId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFormateurId() {

        if (formateurId == null) return 0;
        return formateurId;
    }

    public void setFormateurId(Integer formateurId) {
        this.formateurId = formateurId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromosEntity that = (PromosEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (formateurId != null ? !formateurId.equals(that.formateurId) : that.formateurId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (formateurId != null ? formateurId.hashCode() : 0);
        return result;
    }
}
