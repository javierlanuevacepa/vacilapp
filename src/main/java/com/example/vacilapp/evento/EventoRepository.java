package com.example.vacilapp.evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento,Long>{



    @Query(value = "SELECT e.*, (6371 * acos(cos(radians(:userLat)) * cos(radians(e.latitud)) * cos(radians(e.longitud) - radians(:userLon)) + sin(radians(:userLat)) * sin(radians(e.latitud)))) AS distance " +
                   "FROM evento e " +
                   "HAVING distance <= :kiloCuantos " +
                   "ORDER BY distance", 
           nativeQuery = true)
    List<Evento> encontrarEventosEnElRadioDe(@Param("userLat") double userLat, @Param("userLon") double userLon,@Param("kiloCuantos") double kiloCuantos);

    //ACUERDATE DE PONER 10


}
