## Problem Description

You are developing a platform that needs to send notifications to users through different channels based on user preferences, message urgency, and content type. The system should be able to create different notification handlers without the client code needing to know the specific implementation details of each communication channel.

The system should support:

1. **Email Notifier**: Sends notifications via email
2. **SMS Notifier**: Sends notifications via text message
3. **Push Notifier**: Sends notifications via mobile push notifications

## Requirements

1. **Notification Interface**: Each notification handler should implement a common interface for sending notifications:
   - `NotificationResult sendNotification(String recipient, String subject, String message, Priority priority);`

2. **Extensibility**: The implementation should be easily extensible to add new notification channels
