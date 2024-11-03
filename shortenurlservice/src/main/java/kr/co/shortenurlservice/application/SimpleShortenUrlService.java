package kr.co.shortenurlservice.application;

import kr.co.shortenurlservice.domain.LackOfShortenUrlKeyException;
import kr.co.shortenurlservice.domain.NotFoundShortenUrlException;
import kr.co.shortenurlservice.domain.ShortenUrl;
import kr.co.shortenurlservice.domain.ShortenUrlRepository;
import kr.co.shortenurlservice.presentation.ShortenUrlCreateRequestDto;
import kr.co.shortenurlservice.presentation.ShortenUrlCreateResponseDto;
import kr.co.shortenurlservice.presentation.ShortenUrlInformationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleShortenUrlService {

    private ShortenUrlRepository shortenUrlRepository;

    @Autowired
    SimpleShortenUrlService(ShortenUrlRepository shortenUrlRepository) {
        this.shortenUrlRepository = shortenUrlRepository;
    }
    public ShortenUrlCreateResponseDto generateShortenUrl(
            ShortenUrlCreateRequestDto shortenUrlCreateRequestDto
    ) {
        // 1. 단축 url 키 생성
        String originalUrl = shortenUrlCreateRequestDto.getOriginalUrl();
        String shortenUrlKey = getUniqueShortenUrlKey();

        // 2. 원래의 URL과 단축 url키를 통해 ShortenUrl 도메인 객체 생성
        ShortenUrl shortenUrl = new ShortenUrl(originalUrl, shortenUrlKey);

        // 3. 생성된 ShortenUrl을 레포지토리를 통해 저장
        shortenUrlRepository.saveShortenUrl(shortenUrl);

        // 4. ShortenUrl을 ShortenUrlCreateResponseDto로 변환하여 반환
        ShortenUrlCreateResponseDto shortenUrlCreateResponseDto = new ShortenUrlCreateResponseDto(shortenUrl);
        System.out.println("shortenUrl: " + shortenUrlCreateResponseDto);
        return shortenUrlCreateResponseDto;
    }

    public ShortenUrlInformationDto getShortenUrlInformationByShortenUrlKey(String shortenUrlKey) {
        ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);
        if (null == shortenUrl) {
            throw new NotFoundShortenUrlException();
        }
        ShortenUrlInformationDto shortenUrlInformationDto = new ShortenUrlInformationDto(shortenUrl);

        return shortenUrlInformationDto;
    }

    public String getOriginalUrlByShortenUrlKey(String shortenUrlKey) {
        ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);

        if (null == shortenUrl) {
            throw new NotFoundShortenUrlException();
        }
        shortenUrl.increaseRedirectCount();
        shortenUrlRepository.saveShortenUrl(shortenUrl);

        String originalUrl = shortenUrl.getOriginalUrl();

        return originalUrl;
    }

    private String getUniqueShortenUrlKey() {
        final int MAX_RETRY_COUNT = 5;
        int count = 0;

        while (count++ < MAX_RETRY_COUNT) {
            String shortenUrlKey = ShortenUrl.generateShortenUrlKey();
            ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);

            if(null == shortenUrl) {
                return shortenUrlKey;
            }
        }
        throw new LackOfShortenUrlKeyException();
    }
}
