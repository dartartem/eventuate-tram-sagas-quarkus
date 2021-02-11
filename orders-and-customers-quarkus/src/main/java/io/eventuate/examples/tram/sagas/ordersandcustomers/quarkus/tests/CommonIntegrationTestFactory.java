package io.eventuate.examples.tram.sagas.ordersandcustomers.quarkus.tests;

import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.sagas.createorder.CreateOrderSaga;
import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcherFactory;
import io.eventuate.tram.messaging.common.ChannelMapping;
import io.eventuate.tram.messaging.common.DefaultChannelMapping;

import javax.inject.Singleton;

@Singleton
public class CommonIntegrationTestFactory {
  @Singleton
  public ChannelMapping channelMapping(TramCommandsAndEventsIntegrationData data) {
    return DefaultChannelMapping.builder()
            .with("CustomerAggregate", data.getAggregateDestination())
            .with("customerService", data.getCommandChannel())
            .with(CreateOrderSaga.class.getName(), data.getSagaEventsChannel())
            .build();
  }


  @Singleton
  public TramCommandsAndEventsIntegrationData tramCommandsAndEventsIntegrationData() {
    return new TramCommandsAndEventsIntegrationData();
  }

  @Singleton
  public SagaEventsConsumer sagaEventsConsumer() {
    return new SagaEventsConsumer();
  }

  @Singleton
  public DomainEventDispatcher domainEventDispatcher(TramCommandsAndEventsIntegrationData tramCommandsAndEventsIntegrationData, SagaEventsConsumer sagaEventsConsumer, DomainEventDispatcherFactory domainEventDispatcherFactory) {
    return domainEventDispatcherFactory.make(tramCommandsAndEventsIntegrationData.getEventDispatcherId(), sagaEventsConsumer.domainEventHandlers());
  }
}
