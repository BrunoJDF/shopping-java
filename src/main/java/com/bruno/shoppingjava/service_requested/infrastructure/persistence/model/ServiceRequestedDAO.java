package com.bruno.shoppingjava.service_requested.infrastructure.persistence.model;

import com.bruno.shoppingjava.client.infrastructure.persistence.model.ClientDAO;
import com.bruno.shoppingjava.service_requested.domain.ServiceRequested;
import com.bruno.shoppingjava.service_requested.domain.ServiceStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = ServiceRequestedDAO.SQLServiceRequested.TABLE_NAME)
public class ServiceRequestedDAO {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @Column(name = SQLServiceRequested.DESCRIPTION)
  private String description;

  @Column(name = SQLServiceRequested.SERVICE_NAME)
  private String serviceName;

  @Column(name = SQLServiceRequested.SELLER)
  private String seller;

  @Column(name = SQLServiceRequested.COMMISSION)
  private BigDecimal commission;

  @Column(name = SQLServiceRequested.SUBTOTAL)
  private BigDecimal subtotal;

  @Column(name = SQLServiceRequested.TOTAL)
  private BigDecimal total;

  @Enumerated(EnumType.STRING)
  @Column(name = SQLServiceRequested.STATUS)
  private ServiceStatus status;

  @CreatedBy
  @Column(name = SQLServiceRequested.CREATED_BY)
  private String createdBy;

  @CreatedDate
  @Column(name = SQLServiceRequested.CREATED_DATE)
  private Instant createdDate;

  @LastModifiedBy
  @Column(name = SQLServiceRequested.UPDATED_BY)
  private String updatedBy;

  @LastModifiedDate
  @Column(name = SQLServiceRequested.UPDATED_DATE)
  private Instant updatedDate;

  @ManyToOne
  @JoinColumn(name = SQLServiceRequested.CLIENT)
  private ClientDAO client;

  static class SQLServiceRequested {
    static final String TABLE_NAME = "service_requested";

    static final String DESCRIPTION = "description";
    static final String SERVICE_NAME = "service_name";
    static final String CLIENT = "client_id";
    static final String SELLER = "seller";
    static final String COMMISSION = "commission";
    static final String SUBTOTAL = "subtotal";
    static final String TOTAL = "total";
    static final String STATUS = "status";
    static final String CREATED_BY = "created_by";
    static final String CREATED_DATE = "created_date";
    static final String UPDATED_BY = "updated_by";
    static final String UPDATED_DATE = "updated_date";

    private SQLServiceRequested() {
      throw new IllegalStateException("Utility class");
    }
  }

  public ServiceRequested toDomain() {
    return ServiceRequested.builder()
      .id(this.id)
      .description(this.description)
      .serviceName(this.serviceName)
      .seller(this.seller)
      .commission(this.commission)
      .subtotal(this.subtotal)
      .total(this.total)
      .status(this.status)
      .client(this.client != null ? this.client.toDomain() : null)
      .build();
  }

  public static ServiceRequestedDAO fromDomain(ServiceRequested serviceRequested) {
    return ServiceRequestedDAO.builder()
      .id(serviceRequested.getId())
      .description(serviceRequested.getDescription())
      .serviceName(serviceRequested.getServiceName())
      .seller(serviceRequested.getSeller())
      .commission(serviceRequested.getCommission())
      .subtotal(serviceRequested.getSubtotal())
      .total(serviceRequested.getTotal())
      .status(serviceRequested.getStatus())
      .client(serviceRequested.getClient() != null ? ClientDAO.fromDomain(serviceRequested.getClient()) : null)
      .build();
  }
}
