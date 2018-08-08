
## Jungle Testnet

> Github: https://github.com/CryptoLions/EOS-Jungle-Testnet
> 区块浏览器: http://dev.cryptolions.io

#### 钱包与账户信息

```

// 钱包密码
PW5JDn1zpE7ZseZLz9SrPpX5CBCrywMtyYrDbxsLwAFXJnqQkub22

// 账户1 
account name: digcreditnsh 
Private key: 5JoSRqSBf8VgAFN4Snxg9MMVWBEhoksAxUArvLjVBRDNne2EL5o 
Public key: EOS77McgHYw5xpnmT297fLMSp8KYoQoYZLYauo5vQRzxWLZY8NqZ1  

// 合约账户: creditotoken 
Private key: 5JuZ4zHQ2ky3krUvtxXdYBGTaCPtTeUjY4sSe66jSEPEokcchWZ 
Public key: EOS7KLp9T9zYPCmVXrHXyizbg8Qh5HNfb9d2adiCDjSWMMBnr2VQA  

// 账户2  
acount name: eosiocredit1
Private key: 5J4KhenJgRUAHUQtZHc3yZ1963ft8aiYqxo3DEwuoBFbjoDnkjP 
Public key: EOS8MDCrBb6ZZxqVjdmZR99a2gtDQkTmTsUuUN3xCejSn6fKnAhQv
```

#### 启动 docker

> https://developers.eos.io/eosio-nodeos/docs/docker-quickstart  官方地址

```
sudo docker pull eosio/eos-dev

sudo docker run --rm --name eosio -d -p 8888:8888 -p 9876:9876 -v /tmp/work:/work -v /tmp/eosio/data:/mnt/dev/data -v /tmp/eosio/config:/mnt/dev/config eosio/eos-dev  /bin/bash -c "nodeos -e -p eosio --plugin eosio::wallet_api_plugin --plugin eosio::wallet_plugin --plugin eosio::producer_plugin --plugin eosio::history_plugin --plugin eosio::chain_api_plugin --plugin eosio::history_api_plugin --plugin eosio::http_plugin -d /mnt/dev/data --config-dir /mnt/dev/config --http-server-address=0.0.0.0:8888 --access-control-allow-origin=* --contracts-console --http-validate-host=false"

sudo docker logs --tail 10 eosio

curl http://localhost:8888/v1/chain/get_info

// cleos
alias cleos='sudo docker exec -it eosio /opt/eosio/bin/cleos -u http://jungle.cryptolions.io:18888 --wallet-url http://0.0.0.0:8888'

```

- 新建账户

```
// new account
cleos system newaccount  --stake-net '1.0 EOS' --stake-cpu '1.0 EOS' digcreditnsh creditotoken EOS7KLp9T9zYPCmVXrHXyizbg8Qh5HNfb9d2adiCDjSWMMBnr2VQA EOS7KLp9T9zYPCmVXrHXyizbg8Qh5HNfb9d2adiCDjSWMMBnr2VQA --buy-ram '20 EOS'

```

- 转账 eos



```
// get accounts by the public key
cleos get accounts EOS77McgHYw5xpnmT297fLMSp8KYoQoYZLYauo5vQRzxWLZY8NqZ1

// get account by the account
cleos get account digcreditnsh

// transfer eos
cleos transfer digcreditnsh creditotoken '500 EOS' 'buy'


```

- RAM/CPU/NET


```
// Buy ram
cleos system buyram creditotoken creditotoken "1 EOS"

// Query ram
cleos get account creditotoken

// Sell ram
cleos system sellram creditotoken 1024 -p creditotoken


// Delegate Net and CPU
cleos system delegatebw digcreditnsh creditotoken '1 EOS' '1 EOS'

// Undelegate Net and CPU
cleos  system undelegatebw digcreditnsh creditotoken '0.5 EOS' '0.5 EOS'

permissions:
     owner     1:    1 EOS7KLp9T9zYPCmVXrHXyizbg8Qh5HNfb9d2adiCDjSWMMBnr2VQA
	 Active     1:    1 EOS7KLp9T9zYPCmVXrHXyizbg8Qh5HNfb9d2adiCDjSWMMBnr2VQA
memory:
     quota:     122.5 KiB    used:     3.051 KiB

net bandwidth:
    delegated:       1.0000 EOS           (total staked delegated to account from others)
    used:               364 bytes
    available:        191.6 KiB
    limit:              192 KiB
cpu bandwidth:
    delegated:       1.0000 EOS           (total staked delegated to account from others)
    used:             13.02 ms
    available:        24.43 ms
    limit:            37.44 ms

EOS balances:
    liquid:          489.2485 EOS
    staked:            0.0000 EOS
    unstaking:         0.0000 EOS
    total:           489.2485 EOS

```

- 发行代币

```
// 部署合约
cleos set contract creditotoken contracts/eosio.token -p creditotoken

// 创建代币
cleos push action creditotoken create '{"issuer":"creditotoken","maximum_supply":"1000000000.0000 USDT","can_freeze":"0","can_recall":"0","can_whitel ist":"0"}' -p creditotoken

// 发行代币
cleos set contract creditotoken contracts/eosio.token -p creditotoken

```


