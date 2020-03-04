package io.guiders.api.repository;

import io.guiders.api.domain.Essay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EssayRepository extends JpaRepository<Essay, Long> {

}
