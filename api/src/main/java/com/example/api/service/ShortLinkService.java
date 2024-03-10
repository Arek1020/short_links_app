package com.example.api.service;

import com.example.api.entity.ShortLink;
import com.example.api.repository.ShortLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortLinkService {
    @Autowired
    private ShortLinkRepository shortLinkRepository;
    public ShortLink getLinkById(long id) {
        return shortLinkRepository.findById((long) id).orElse(null);
    }

    public ShortLink shortenLink(String oryginalLink) {
        ShortLink shortLink = new ShortLink();
        shortLink.setLink(oryginalLink);

        shortLinkRepository.save(shortLink);

        String serverUrl = "http://localhost:8080/link/";

        String completeShortUrl = serverUrl + shortLink.getId().toString();
        shortLink.setLink(completeShortUrl);

        return shortLink;
    }
}
