## Problem Description

You are developing an e-commerce platform that needs to handle different payment methods. The system should be able to process payments through various payment gateways without the client code needing to know the specific implementation details of each payment method.

The system should support:

1. **Credit Card Processor**: Processes payments via credit/debit cards
2. **PayPal Processor**: Processes payments through PayPal gateway
3. **Bank Transfer Processor**: Processes payments via direct bank transfers

## Requirements

1. **Payment Interface**: - Each payment processor should implement a common interface for processing payments:
   - `PaymentResult processPayment(double amount)`

2. **Extensibility**: The implementation should be easily extensible to add new payment types