package com.solvd.carinatesting.apimethods;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

// https://docs.github.com/en/rest/commits/comments#create-a-commit-comment
@Endpoint(url = "${base_url}/repos/${user}/${repo}/commits/${commit}/comments", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/commit_comment/rq.json")
@ResponseTemplatePath(path = "api/commit_comment/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostCommitComment extends AbstractApiMethodV2 {

    public PostCommitComment(String user, String repo, String commit, String comment) {
        setHeader("Authorization", "Bearer " + Configuration.getRequired("github_token"));
        replaceUrlPlaceholder("base_url", Configuration.getRequired("github_api_url"));
        replaceUrlPlaceholder("user", user);
        replaceUrlPlaceholder("repo", repo);
        replaceUrlPlaceholder("commit", commit);
        addProperty("comment", comment);
    }
}