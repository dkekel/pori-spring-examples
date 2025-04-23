package cern.pori.spring.service;

import static org.mockito.Mockito.when;

import cern.pori.spring.model.SpringCampusEntity;
import cern.pori.spring.repository.SpringCampusJpaRepository;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SpringCampusServiceTest {

  @Mock
  private SpringCampusJpaRepository jpaRepository;

  @InjectMocks
  private SpringCampusService service;

  @Test
  void testGetAllEntitiesNoData() {
    //Given
    when(jpaRepository.findAll()).thenReturn(Collections.emptyList());

    //When
    var result = service.getAllEntities();

    //Then
    assert result.isEmpty();
  }

  @Test
  void testGetAllEntitiesWithData() {
    //Given
    var entity1 = new SpringCampusEntity();
    entity1.setName("Campus A");
    entity1.setCity("City A");

    var entity2 = new SpringCampusEntity();
    entity2.setName("Campus B");
    entity2.setCity("City B");

    when(jpaRepository.findAll()).thenReturn(List.of(entity1, entity2));

    //When
    var result = service.getAllEntities();

    //Then
    assert result.size() == 2;
    assert result.get(0).getName().equals("Campus A");
    assert result.get(1).getName().equals("Campus B");
  }
}
