from abc import ABC, abstractmethod

# Character interface
class Character(ABC):
    @abstractmethod
    def attack(self):
        pass

    @abstractmethod
    def defend(self):
        pass

    @abstractmethod
    def get_description(self):
        pass

# Concrete Medieval characters
class MedievalWarrior(Character):
    def attack(self):
        print("Medieval Warrior attacks with sword")

    def defend(self):
        print("Medieval Warrior defends with shield")

    def get_description(self):
        return "A brave medieval warrior"

class MedievalMage(Character):
    def attack(self):
        print("Medieval Mage casts fireball")

    def defend(self):
        print("Medieval Mage uses magic barrier")

    def get_description(self):
        return "A wise medieval mage"

# Concrete Sci-Fi characters
class SciFiWarrior(Character):
    def attack(self):
        print("Sci-Fi Warrior shoots laser gun")

    def defend(self):
        print("Sci-Fi Warrior activates energy shield")

    def get_description(self):
        return "A futuristic sci-fi warrior"

class SciFiMage(Character):
    def attack(self):
        print("Sci-Fi Mage uses plasma bolt")

    def defend(self):
        print("Sci-Fi Mage deploys force field")

    def get_description(self):
        return "An advanced sci-fi mage"

# Abstract Factory for creating families of characters
class CharacterFactory(ABC):
    @abstractmethod
    def create_warrior(self) -> Character:
        pass

    @abstractmethod
    def create_mage(self) -> Character:
        pass

# Concrete Factory for Medieval theme with Singleton
class MedievalFactory(CharacterFactory):
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(MedievalFactory, cls).__new__(cls)
        return cls._instance

    def create_warrior(self) -> Character:
        return MedievalWarrior()

    def create_mage(self) -> Character:
        return MedievalMage()

# Concrete Factory for Sci-Fi theme with Singleton
class SciFiFactory(CharacterFactory):
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(SciFiFactory, cls).__new__(cls)
        return cls._instance

    def create_warrior(self) -> Character:
        return SciFiWarrior()

    def create_mage(self) -> Character:
        return SciFiMage()


if __name__ == "__main__":

    factory = MedievalFactory()
    warrior = factory.create_warrior()
    mage = factory.create_mage()

    print(warrior.get_description())
    warrior.attack()
    warrior.defend()

    print(mage.get_description())
    mage.attack()
    mage.defend()

    # Switch to another theme
    factory = SciFiFactory()
    warrior = factory.create_warrior()

    print(warrior.get_description())
    warrior.attack()

    # Extensibility: Add new theme by creating new factory and characters
    # Add new class by adding method to CharacterFactory and implementing in concretes