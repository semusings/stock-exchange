---
marp: true
theme: your-theme
paginate: true
header: '© Software Engineering Musings - <https://bhuwanupadhyay.dev/> - subscribe us on <https://youtube.com/@semusings>'
---

## System Design : Stock Exchange


---

## Step 1—Design Scope

- Q: supported securities: _stocks_
- Q: business functions: 
  - _placing a new order_ 
  - _canceling an order_
- Q: supports trading after normal hours: _no_
- Q: business scale requirements:
    - how many users: _at least ten of thousands of users trading concurrently_
    - how many symbols: _at least 100 symbols_
    - how many orders: _billions of orders per day_
- Q: risk checks or constraints:
    - _user can only trade a maximum of 1 million shares per day for a single symbol_
- non-functional requirements:
    - availability: _99.99%_
    - fault tolerance:
        - _no data loss and fast recovery mechanisms are needed to limit the impact of a production incident_
    - latency:
        - _round-trip latency should be at the millisecond level; focus on low 99th percentile latency_
        - _round-trip latency measured from the moment a market order enters the exchange to the point where the market order
          returns as filled execution_
    - security:
        - _should have an account management system and do KYC check to verify a user's before a new account is opened_
        - _prevent distributed denial of service (DDoS) attacks on public page containing market data_
- back-of-the-envelope calculations:
    - _100 symbols_
    - _1 billion orders per day_
    - _the stock exchange operates for 6.5 hours per day (9:30 am to 4:00 pm) Monday to Friday_
    - _QPS = 1 billion orders / (6.5 hours * 3600 seconds) =~ 50,000 orders per second_
    - _peak QPS = 5 * QPS = 250,000 orders per second; trading volume is usually 5 times higher at the opening and
      closing hours_

---

## Step 2—High-Level Design