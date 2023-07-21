package com.sivasrinivas;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeperService service = new ZooKeeperService();
        var path = "/root";
        var message = "hello world!";

        service.put(path, message);
        System.out.println(service.get(path));

        service.closeConnection();
    }
}