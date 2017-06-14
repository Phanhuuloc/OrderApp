package com.example.oa.orderapp.data;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by Phoenix on 6/14/17.
 */

public class Menu extends RealmObject implements ODObject{
    @Ignore
    private UUID uuid;
    private String name;
    private String description;
}
