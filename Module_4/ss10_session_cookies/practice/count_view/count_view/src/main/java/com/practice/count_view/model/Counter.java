package com.practice.count_view.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Counter {
    @Id
    private Integer count;

    public Counter() {
    }

    public Counter(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer increment() {
        return count++;
    }
}
