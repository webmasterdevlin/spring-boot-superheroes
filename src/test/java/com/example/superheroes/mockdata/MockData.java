package com.example.superheroes.mockdata;

import com.example.superheroes.villain.model.Villain;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MockData {
    public static List<Villain> getVillains() throws IOException {
        InputStream inputStream = Resources.getResource("fakedata/villains.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<Villain>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }
}
