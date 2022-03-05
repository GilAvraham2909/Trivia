package com.trivia.champion.db;

import com.trivia.champion.AppConfig;
import com.trivia.champion.enums.DbTypes;
import com.trivia.champion.enums.UiTypes;
import com.trivia.champion.ui.output.PlayerConsole;
import com.trivia.champion.ui.output.PlayerGui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import static com.trivia.champion.utils.Constants.*;

public class DbAdapter {
    private int dbType;

    public DbAdapter() throws IOException {
        try {
            dbType = Integer.parseInt(Objects.requireNonNull(AppConfig.loadProperty(PROPERTY_DB_TYPE)));
        } catch (Exception e) {
            setDbTypeToDefault();
        }
    }

    public IDB getDb() throws Exception {
        if (dbType == DbTypes.SQLITE.ordinal())
            return new SqliteDB();
        else
            return new MongoDB();
    }

    private void setDbTypeToDefault() throws IOException {
        AppConfig.setProperty(PROPERTY_DB_TYPE, DEFAULT_DB_TYPE.toString());
    }

}