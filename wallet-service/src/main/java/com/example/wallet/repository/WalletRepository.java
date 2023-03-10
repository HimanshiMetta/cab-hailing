package com.example.wallet.repository;

import com.example.wallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    @Query("select w from Wallet w where w.custId = ?1")
    Wallet findByCustId(int custId);

    @Modifying
    @Query("update Wallet w set w.walletAmount = ?2 where w.custId = ?1")
    @Transactional
    void updateWallet(int custId, int amountUpdate);

    @Modifying
    @Query("update Wallet w set w.walletAmount = ?1")
    @Transactional
    void updateAllWallet(int amountUpdate);
}
