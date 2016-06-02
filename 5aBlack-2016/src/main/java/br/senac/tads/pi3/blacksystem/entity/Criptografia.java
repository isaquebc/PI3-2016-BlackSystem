/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.entity;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Fernando
 */
public final class Criptografia implements Serializable {
    
    
    
    public Criptografia() {

    }

    public Criptografia(Usuario s) {
        try {
            s.setHashSenha(gerarHashSenhaPBKDF2(s));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Geração do hash da senha usando algoritmo MD5 (mais comum). Não usado
     * neste exemplo
     *
     * @param senha
     * @return
     */
    private char[] gerarHashSenhaMD5(String senha) {
        try {
            // SALT (EM SITUACOES REAIS, DEVEM SER DIFERENTES PARA CADA USUARIO)

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            byte[] digested = md.digest(("salt" + senha).getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digested.length; i++) {
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString().toCharArray();
        } catch (NoSuchAlgorithmException ex) {
            //Logger.getLogger(this.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Geração do hash da senha usando algoritmo PBKDF2WithHmacSHA1 (mais
     * seguro) Exemplo obtido em
     * http://www.javacodegeeks.com/2012/05/secure-password-storage-donts-dos-and.html
     *
     * Depois que o hash é gerado, não é possível recuperar a senha original.
     *
     * @PowerMockIgnore ("javax.crypto.*")
     * @param senha
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public String gerarHashSenhaPBKDF2(Usuario s) throws NoSuchAlgorithmException, InvalidKeySpecException {
   // PBKDF2 with SHA-1 as the hashing algorithm. Note that the NIST
        // specifically names SHA-1 as an acceptable hashing algorithm for PBKDF2
        String algorithm = "PBKDF2WithHmacSHA1";
        // SHA-1 generates 160 bit hashes, so that's what makes sense here
        int derivedKeyLength = 160;
    // Pick an iteration count that works for you. The NIST recommends at
        // least 1,000 iterations:
        // http://csrc.nist.gov/publications/nistpubs/800-132/nist-sp800-132.pdf
        // iOS 4.x reportedly uses 10,000:
        // http://blog.crackpassword.com/2010/09/smartphone-forensics-cracking-blackberry-backup-passwords/
        int iterations = 2000;

    // SALT (EM SITUACOES REAIS, DEVEM SER DIFERENTES PARA CADA USUARIO)
        // Normalmente, deve ser alguma informação que, após cadastrado, não pode mais ser alterado.
        String salt = s.getSalt();

        KeySpec spec = new PBEKeySpec(s.getHashSenha().toCharArray(), s.getSalt().getBytes(), iterations, derivedKeyLength);
        SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);

        byte[] code = f.generateSecret(spec).getEncoded();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < code.length; i++) {
            sb.append(Integer.toHexString(0xff & code[i]));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

   

    /**
     * Verifica se usuário possui autorização de acesso baseado nos cargo que
     * possui.
     *
     * @param papelNecessario
     * @return
     */
//  public boolean autorizado(String papelNecessario) {
//    List<String> papeisUsuario = Arrays.asList(this.cargo);
//    return papeisUsuario.contains(papelNecessario);
//  }
    public String convertParaHex() {
        char[] hexa = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        Random r = new Random();
        String salt = "";
        for (int j = 0; j < 15; j++) {
            salt += hexa[r.nextInt(15)];
        }
        return salt;
    }
    
    

}
