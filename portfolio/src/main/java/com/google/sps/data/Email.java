package com.google.sps.data;

/** Email. */
public final class Email {

  private final long id;
  private final String emailaddress;
  private final String emailmessage;
  private final long timestamp;

  public Email(long id, String emailaddress, String emailmessage, long timestamp) {
    this.id = id;
    this.emailaddress = emailaddress;
    this.emailmessage = emailmessage;
    this.timestamp = timestamp;
  }
}