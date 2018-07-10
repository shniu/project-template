alias pcleos='sudo docker exec eosio-dev /opt/eosio/bin/cleos --wallet-url http://localhost:8888 -u  http://seed.party.tc.ink:8888'

 pcleos system newaccount --stake-net '1 SYS' --stake-cpu '1 SYS' --buy-ram-kbytes 10 digcreditnsh creditotoken EOS7KLp9T9zYPCmVXrHXyizbg8Qh5HNfb9d2adiCDjSWMMBnr2VQA

cleosdev wallet create -n party

cleosdev wallet import 
