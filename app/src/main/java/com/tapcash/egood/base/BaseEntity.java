package com.tapcash.egood.base;

import java.io.Serializable;

/**
 * Created by TC10795 on 2017/8/9.
 */

public class BaseEntity<E> implements Serializable {
    public int status;
    public E content;
}
