package jw.project.infrastructure;

import jw.project.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaShopRepository extends JpaRepository<Shop, Long> {
}
