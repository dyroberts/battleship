package com.demo.battleship.game;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Ship {
    private String name;
    private Integer size;
    private Integer damage = 0;

    public Ship(String name, Integer size) {
        this.name = name;
        this.size = size;
    }

    public Integer getDamage() {
        return damage;
    }

    public Integer getSize() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
