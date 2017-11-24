package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public void loadUsers() {
        ArrayList<User> users = new ArrayList<>();
        modelData.setUsers(users);
        modelData.getUsers().add(new User("A", 1, 1));
        modelData.getUsers().add(new User("B", 2, 1));
    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }
}
