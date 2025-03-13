package com.solvd.carinatesting.apimethods;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

// https://docs.github.com/en/rest/commits/comments#create-a-commit-comment
@Endpoint(url = "${base_url}/repos/iza-j/carina-testing/commits/a87c735058883da708549a0d78d9529f9e9b83e1/comments", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/commit_comment/rq.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostCommitComment extends AbstractApiMethodV2 {

    public PostCommitComment() {
        setHeader("Authorization", "Bearer " + Configuration.getRequired("github_token"));
        replaceUrlPlaceholder("base_url", Configuration.getRequired("github_api_url"));
    }
}