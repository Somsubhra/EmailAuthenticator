EmailAuthenticator
=====
Filters wrong email id and password combinations from valid ones for any IMAP mail server.

### Instructions
=====
*  Add records.csv file containing email data in following format:

```
<imap_host>,<imap_port>,<SSL={true,false}>,<email>,<password>
```

* Output is written to legal_records.csv and illegal_records.csv.