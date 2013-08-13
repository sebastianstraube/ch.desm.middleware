#pragma once

#include <vector>
#include <Windows.h>

// TODO convert fatal and api misuse error codes to exceptions?

namespace desm {

	class MwDll {
	public:
		MwDll(LPCWSTR dllName);
		~MwDll();
	public:
		std::string infoVersion();
		std::string infoName();
		std::string infoDescription();
		
		void onStartProgramm(const std::string& configPath);
		void onStopProgramm();

		//TODO Sebastian
		//ON command
		void onStartSimulation();
		void onStopSimulation();
		void onLoadStrecke(void);
		//SET command
		bool setTrack(int gleisId, double von, double bis, double abstand, const std::string& name);
		bool setTrackConnection(int gleisId, int gleis1, int gleis2, double von, double bis, const std::string& name, int weiche1Id, int weiche2Id);
		bool setSignal(int signalId, int gleisId, double position, int typ, double hoehe, double distanz, const std::string& name, int direction);
		bool setBalise(int gleisId, double position, int baliseId, int direction);
		bool setLoop(int gleisId, double positionVon, double positionBis, int baliseId);
		bool setIsolierstoss(int gleisId, double position);
		bool setKilometerDirection(int direction);
		//GET command
		bool getKilometerDirection(int& direction);
		bool getEvents(std::vector<int>& typeList, std::vector<int>& idList);
		bool getSignal(int signalId, int& stellung);
		bool getBalise(int baliseId, int& stellung, std::string& protokoll);
		bool getLoop(int baliseId, int& stellung, std::string& protokoll);
		bool getWeiche(int weicheId, int& gleisId);
		bool setTrainPosition(int train, int direction, const std::vector<double>& positionList, const std::vector<int>& gleisList);

	private:
		struct Impl;
		Impl* m_pImpl;
	};
}