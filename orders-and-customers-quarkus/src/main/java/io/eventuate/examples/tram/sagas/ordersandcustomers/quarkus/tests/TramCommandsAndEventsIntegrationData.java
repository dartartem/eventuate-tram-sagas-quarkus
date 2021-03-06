package io.eventuate.examples.tram.sagas.ordersandcustomers.quarkus.tests;

public class TramCommandsAndEventsIntegrationData {

  private long now = System.currentTimeMillis();
  private String commandDispatcherId = "command-dispatcher-" + now;
  private String commandChannel = "command-channel-" + now;
  private String aggregateDestination = "aggregate-destination-" + now;
  private String eventDispatcherId  = "event-dispatcher-" + now;
  private String sagaEventsChannel = "sagaEventsChannel-" + now;

  public String getAggregateDestination() {
    return aggregateDestination;
  }


  public String getCommandDispatcherId() {
    return commandDispatcherId;
  }

  public String getCommandChannel() {
    return commandChannel;
  }

  public String getEventDispatcherId() {
    return eventDispatcherId;
  }

  public String getSagaEventsChannel() {
    return sagaEventsChannel;
  }
}
