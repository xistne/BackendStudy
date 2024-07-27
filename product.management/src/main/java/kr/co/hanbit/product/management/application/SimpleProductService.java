package kr.co.hanbit.product.management.application;

import kr.co.hanbit.product.management.domain.Product;
import kr.co.hanbit.product.management.infrastructure.ListProductRepository;
import kr.co.hanbit.product.management.presentation.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleProductService {
    private ListProductRepository listProductRepository;
    private ModelMapper modelMapper;

    @Autowired
    SimpleProductService(ListProductRepository listProductRepository, ModelMapper modelMapper) {
        this.listProductRepository = listProductRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDto add(ProductDto productDto) {
        // 1. ProductDto를 Product로 변환하는 코드
        Product product = modelMapper.map(productDto, Product.class);

        // 2. 레포지토리를 호출하는 코드
        Product savedProduct = listProductRepository.add(product);

        // 3. Product를 ProductDto로 변환하는 코드
        ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);

        // 4. DTO를 반환하는 코드
        return savedProductDto;
    }
}