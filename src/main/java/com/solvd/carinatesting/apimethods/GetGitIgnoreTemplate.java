package com.solvd.carinatesting.apimethods;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

// https://docs.github.com/en/rest/gitignore/gitignore#get-a-gitignore-template
@Endpoint(url = "${base_url}/gitignore/templates/Java", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetGitIgnoreTemplate extends AbstractApiMethodV2 {

    public GetGitIgnoreTemplate() {
        setHeader("Authorization", "Bearer " + Configuration.getRequired("github_token"));
        replaceUrlPlaceholder("base_url", Configuration.getRequired("github_api_url"));
    }
}