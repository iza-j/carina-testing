package com.solvd.carinatesting.apimethods;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

// https://docs.github.com/en/rest/gitignore/gitignore#get-a-gitignore-template
@Endpoint(url = "${base_url}/gitignore/templates/${language_name}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/git_ignore_template/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetGitIgnoreTemplate extends AbstractApiMethodV2 {

    public GetGitIgnoreTemplate(String languageName) {
        setHeader("Authorization", "Bearer " + Configuration.getRequired("github_token"));
        replaceUrlPlaceholder("base_url", Configuration.getRequired("github_api_url"));
        replaceUrlPlaceholder("language_name", languageName);
        addProperty("language_name", languageName);
    }
}