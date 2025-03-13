package com.solvd.carinatesting;

import com.solvd.carinatesting.apimethods.GetEmojis;
import com.solvd.carinatesting.apimethods.GetGitIgnoreTemplate;
import com.solvd.carinatesting.apimethods.PostCommitComment;
import com.solvd.carinatesting.helpers.FreeMarkerEngine;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GithubAPITest implements IAbstractTest {

    @Test(description = "List all the emojis available to use on GitHub.", enabled = true)
    @MethodOwner(owner = "iza-j")
    public void testGetEmojis() {
        GetEmojis method = new GetEmojis();
        method.callAPIExpectSuccess();
        method.validateResponseAgainstSchema("api/emojis/rs.schema");
    }

    @BeforeSuite(alwaysRun = true, enabled = true)
    @MethodOwner(owner = "iza-j")
    public void beforeGetGitIgnoreTemplate() {
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("language_name", "Java");
        freeMarkerEngine.processAndSave("api/git_ignore_template/rs.ftl", dataModel, "src/test/resources/api/git_ignore_template/rs.json");
    }

    @Test(description = "Get the content of a gitignore template.", enabled = true)
    @MethodOwner(owner = "iza-j")
    public void testGetGitIgnoreTemplate() {
        GetGitIgnoreTemplate method = new GetGitIgnoreTemplate();
        method.setResponseTemplate("api/git_ignore_template/rs.json");
        method.callAPIExpectSuccess();
        method.validateResponse(JSONCompareMode.STRICT);
    }

    @Test(description = "Create a comment for a commit.", enabled = true)
    @MethodOwner(owner = "iza-j")
    public void testPostCommitComment() {
        PostCommitComment method = new PostCommitComment();
        method.callAPIExpectSuccess();
        method.validateResponseAgainstSchema("api/commit_comment/rs.schema");
    }
}