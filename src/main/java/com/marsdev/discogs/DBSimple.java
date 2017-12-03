package com.marsdev.discogs;

import ru.blizzed.discogsdb.DiscogsAuthData;
import ru.blizzed.discogsdb.DiscogsDBApi;
import ru.blizzed.discogsdb.DiscogsDBCallException;
import ru.blizzed.discogsdb.DiscogsDBErrorException;
import ru.blizzed.discogsdb.model.Page;
import ru.blizzed.discogsdb.model.search.BaseSearchResult;
import ru.blizzed.discogsdb.model.search.ReleaseSearchResult;
import ru.blizzed.discogsdb.params.DiscogsDBParams;

public class DBSimple {

    public static void main(String[] args) throws DiscogsDBCallException, DiscogsDBErrorException {

        DiscogsDBApi.initialize(new DiscogsAuthData("", ""));

        String userInput = "Prince";
        Page<BaseSearchResult> page = DiscogsDBApi.searchArtist(DiscogsDBParams.QUERY.of(userInput)).execute();
        Page<ReleaseSearchResult> page2 = DiscogsDBApi.searchRelease(DiscogsDBParams.QUERY.of(userInput)).execute();

        page2.getContent().forEach(sr -> System.out.println(sr.getTitle() + " " + sr.getYear() + " " + sr.getCountry()));

        long princeId = page.getContent().get(0).getId();
        System.out.println("Prince Id:  " + princeId);

        try {
            DiscogsDBApi.getArtist(princeId).execute().getNameVariations().forEach(System.out::println);
        } catch (DiscogsDBCallException | DiscogsDBErrorException e) {
            e.printStackTrace();
        }


    }
}
