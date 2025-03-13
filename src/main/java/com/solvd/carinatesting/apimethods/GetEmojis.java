package com.solvd.carinatesting.apimethods;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

// https://docs.github.com/en/rest/emojis/emojis
@Endpoint(url = "${base_url}/emojis", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetEmojis extends AbstractApiMethodV2 {

    public GetEmojis() {
        setHeader("Authorization", "Bearer " + Configuration.getRequired("github_token"));
        replaceUrlPlaceholder("base_url", Configuration.getRequired("github_api_url"));
    }
}