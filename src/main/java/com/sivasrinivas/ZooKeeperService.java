package com.sivasrinivas;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZooKeeperService {
    private final ZooKeeper zooKeeper;

    public ZooKeeperService() throws IOException {
        this.zooKeeper = new ZooKeeper("localhost:2181", 3000, null);
    }

    public void put(String path, String message) throws InterruptedException, KeeperException {
        zooKeeper.create(path, message.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public String get(String path) throws InterruptedException, KeeperException {
        byte[] data = zooKeeper.getData(path, false, null);
        return new String(data);
    }

    public void closeConnection() throws InterruptedException {
        this.zooKeeper.close();
    }
}
