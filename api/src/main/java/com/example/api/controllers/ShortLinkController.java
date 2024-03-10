package com.example.api.controllers;

import com.example.api.entity.ShortLink;
import com.example.api.service.ShortLinkService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
//@RequestMapping(value = "/link")
public class ShortLinkController {

    private ShortLinkService shortLinkService;

    public ShortLinkController(ShortLinkService shortLinkService){
        this.shortLinkService = shortLinkService;
    }

    @PostMapping("/link/create")
    public ShortLink createLink(@RequestBody ShortLink body) {
        ShortLink shortenedLink = shortLinkService.shortenLink(body.getLink());
        return shortenedLink;
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirectToLink(@PathVariable long linkId) {
        ShortLink shortLink = shortLinkService.getLinkById(linkId);
        if (shortLink.getLink() != null) {
            return new RedirectView(shortLink.getLink());
        } else {
            return new RedirectView("/404"); // Redirect to a 404 page or handle accordingly
        }
    }


}
