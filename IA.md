# Utilisation de l'IA — TP1

## Problème rencontré : Port 4848 déjà utilisé par Payara

### 1. Problème rencontré

Lors du lancement de mon application TP1 sur le serveur Payara depuis IntelliJ IDEA, le serveur ne démarrait pas et affichait le message suivant :

```text
Error running 'TP1_Chorouk'
Address localhost:4848 is already in use
```

Je ne comprenais pas pourquoi le serveur refusait de démarrer alors que la configuration du projet semblait correcte.

### 2. Raison de l'utilisation de l'IA

Après avoir rencontré ce blocage, j'ai utilisé l'IA pour comprendre la signification du message d'erreur et identifier le programme qui utilisait déjà le port 4848.

Mon objectif était de résoudre ce problème pour pouvoir poursuivre les tests de mon application.

### 3. Prompt utilisé

« Lors du lancement de mon projet TP1_Chorouk sur Payara dans IntelliJ IDEA, j'obtiens l'erreur suivante : Address localhost:4848 is already in use. Comment résoudre ce problème ? »

### 4. Réponse de l'IA

L'IA m'a expliqué que le port 4848, utilisé par la console d'administration de Payara, était probablement déjà occupé par une autre instance du serveur.

Elle m'a proposé d'identifier le processus utilisant ce port avec la commande PowerShell suivante :

```powershell
netstat -ano | findstr :4848
```

Puis de vérifier le programme correspondant au PID obtenu :

```powershell
tasklist /FI "PID eq 12345"
```

Le nombre `12345` est un exemple à remplacer par le PID réellement affiché.

L'IA m'a expliqué qu'il fallait vérifier le processus avant de l'arrêter, afin de ne pas interrompre une autre application par erreur.

### 5. Ce que j'ai appris

J'ai compris qu'un port réseau ne peut généralement pas être utilisé simultanément par deux serveurs qui souhaitent écouter sur la même adresse.

J'ai également appris à utiliser `netstat` pour identifier les ports occupés et `tasklist` pour retrouver le programme associé à un PID.

Cette expérience m'a permis de mieux comprendre le fonctionnement du serveur Payara et de savoir comment diagnostiquer un conflit de ports lors du démarrage d'une application Jakarta EE.
