package com.platzimarket.persistence.mapper;

import com.platzimarket.domain.PurchaseItem;
import com.platzimarket.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

// Se deben incluir los mappers que se han creado pero que se han nombrado como ignorados
@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto", target="productId"),
            @Mapping(source = "cantidad", target="quantity"),
            // @Mapping(source = "total", target="total"), cuando tiene el mismo nombre, no es necesario especificarlo

            @Mapping(source = "estado", target="active"),
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target="compra", ignore = true),
            @Mapping(target="producto", ignore = true),
            @Mapping(target="id.idCompra", ignore = true),
    })
    ComprasProducto toComprasProducto(PurchaseItem item);
}
