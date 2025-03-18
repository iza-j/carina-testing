package com.solvd.carinatesting;

import com.solvd.carinatesting.apimethods.GetEmojis;
import com.solvd.carinatesting.apimethods.GetGitIgnoreTemplate;
import com.solvd.carinatesting.apimethods.PostCommitComment;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class GithubAPITest implements IAbstractTest {

    @Test(description = "List all the emojis available to use on GitHub.", enabled = true)
    @MethodOwner(owner = "iza-j")
    public void testGetEmojis() {
        GetEmojis method = new GetEmojis();
        method.callAPIExpectSuccess();
        method.validateResponseAgainstSchema("api/emojis/rs.schema");
    }

    @Test(description = "Get the content of a gitignore template.", enabled = true)
    @MethodOwner(owner = "iza-j")
    public void testGetGitIgnoreTemplate() {
        GetGitIgnoreTemplate method = new GetGitIgnoreTemplate("Java");
        method.callAPIExpectSuccess();
        method.validateResponse(JSONCompareMode.STRICT);
    }

    @Test(description = "Create a comment for a commit.", enabled = true)
    @MethodOwner(owner = "iza-j")
    public void testPostCommitComment() {
        PostCommitComment method = new PostCommitComment("iza-j", "carina-testing", "a87c735058883da708549a0d78d9529f9e9b83e1", "...");
        method.callAPIExpectSuccess();
        method.validateResponse(JSONCompareMode.STRICT);
    }
}